# Kafka Consumer Threading Models

## Tại sao cần Thread riêng?

`poll()` là **blocking** → Chạy trên Main Thread sẽ làm treo ứng dụng.

---

## So sánh 2 Mô hình

| Tiêu chí | 1 Thread - 1 Consumer | Worker Pool |
|----------|----------------------|-------------|
| **Cách hoạt động** | Mỗi thread sở hữu 1 Consumer, xử lý tuần tự | 1 thread poll(), đẩy cho thread pool xử lý song song |
| **Throughput** | Thấp | Cao |
| **Độ phức tạp** | Đơn giản | Phức tạp |
| **Commit offset** | Dễ, an toàn | Khó, dễ mất data |
| **Message ordering** | ✅ Đảm bảo | ❌ Không đảm bảo |
| **Thread-safe** | ✅ An toàn | ⚠️ Cần xử lý cẩn thận |
| **Scale** | Tăng partition + consumer | Tăng worker trong pool |

---

## Khi nào dùng Worker Pool?

| Dùng Worker Pool ✅ | Không cần Worker Pool ❌ |
|---------------------|-------------------------|
| Processing time cao (>50ms/msg) | Processing time thấp (<10ms/msg) |
| Gọi external API, DB, I/O nặng | Simple transformations |
| Message rate cao, ít partition | Có thể scale bằng partition |
| Cần parallelism | Message ordering quan trọng |

---

## Vấn đề chính của Worker Pool: Out-of-Order Commit

```
Poll: [offset 1, 2, 3, 4, 5]
       ↓
Workers xử lý song song:
  - Offset 1 ✅ done
  - Offset 2 ❌ FAIL  ← Nếu commit offset 5 → MẤT DATA offset 2!
  - Offset 3 ✅ done
  - Offset 4 ✅ done
  - Offset 5 ✅ done
```

---

## Giải pháp quản lý Commit trong Worker Pool

| Giải pháp | Mô tả | Ưu điểm | Nhược điểm |
|-----------|-------|---------|------------|
| **Batch Barrier** | Đợi TẤT CẢ workers xong mới commit | Đơn giản, an toàn | 1 worker chậm → cả batch đợi |
| **Offset Tracking** | Track offset liên tục, chỉ commit offset "safe" | Throughput cao nhất | Rất phức tạp, memory overhead |
| **Pause/Resume** | Pause consumer khi pending > threshold | Back-pressure tự nhiên | Commit không thường xuyên |

### Giải pháp đề xuất

```
Throughput thấp/trung bình → 1 Thread - 1 Consumer (+ tăng partition)
Throughput cao, chấp nhận đơn giản → Worker Pool + Batch Barrier
Throughput cực cao, chấp nhận phức tạp → Worker Pool + Offset Tracking
```

---

## Alternative: Dùng Framework

| Framework | Đặc điểm |
|-----------|----------|
| **Spring Kafka** | `ConcurrentKafkaListenerContainerFactory` - tự động quản lý threads + commit |
| **Kafka Streams** | Built-in parallelism, exactly-once semantics |
| **Reactor Kafka** | Reactive streams, non-blocking, back-pressure |

→ Đã giải quyết sẵn threading + commit, production-ready.

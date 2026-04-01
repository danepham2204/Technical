import numpy as np


def multiply_optimal(matrix, vector):
    A = np.array(matrix)
    x = np.array(vector)

    # Sử dụng toán tử @ cho phép nhân ma trận (Matrix Multiplication)
    # Hoặc np.dot(A, x)
    return A @ x

# Chạy thử nghiệm


transformation_matrix = [
    [2.0, 0.0],
    [0.0, 1.0]
]
v = [3, 4]

res_optimal = multiply_optimal(transformation_matrix, v)
print(f"Optimal (NumPy) Result: {res_optimal}")

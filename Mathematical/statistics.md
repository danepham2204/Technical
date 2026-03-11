# Statistics

## 1. Descriptive Statistics

Descriptive statistics summarize and describe the main features of a dataset.

### Mean (Average)

The **mean** is the sum of all values divided by the number of values.

$$\mu = \frac{1}{n} \sum_{i=1}^n x_i$$

- Sensitive to outliers.
- Best used when data is roughly symmetric.

### Variance

**Variance** measures how spread out values are from the mean.

**Population variance:**
$$\sigma^2 = \frac{1}{n} \sum_{i=1}^n (x_i - \mu)^2$$

**Sample variance** (unbiased estimator, Bessel's correction):
$$s^2 = \frac{1}{n-1} \sum_{i=1}^n (x_i - \bar{x})^2$$

- Unit: squared units of the original data.

### Standard Deviation

**Standard deviation** is the square root of variance — it restores the original unit.

**Population:**
$$\sigma = \sqrt{\sigma^2}$$

**Sample:**
$$s = \sqrt{s^2}$$

- ~68% of data falls within $\mu \pm \sigma$ for a normal distribution.
- ~95% falls within $\mu \pm 2\sigma$.

### Summary Table

| Measure | Formula | Sensitive to Outliers |
|---|---|---|
| Mean | $\frac{1}{n}\sum x_i$ | Yes |
| Variance | $\frac{1}{n-1}\sum (x_i - \bar{x})^2$ | Yes |
| Std Dev | $\sqrt{\text{Variance}}$ | Yes |

---

## 2. Covariance

**Covariance** measures how two variables $X$ and $Y$ change together.

$$\text{Cov}(X, Y) = \frac{1}{n-1} \sum_{i=1}^n (x_i - \bar{x})(y_i - \bar{y})$$

| Value | Meaning |
|---|---|
| $> 0$ | $X$ and $Y$ tend to increase together |
| $< 0$ | $X$ increases as $Y$ decreases |
| $= 0$ | No linear relationship |

> **Note**: Covariance magnitude depends on the scale of variables, making it hard to compare across datasets.

---

## 3. Correlation

**Correlation** normalizes covariance to a unitless scale $[-1, 1]$, making it easier to interpret.

### Pearson Correlation Coefficient

The most common measure of **linear** correlation:

$$r = \frac{\text{Cov}(X, Y)}{\sigma_X \cdot \sigma_Y} = \frac{\sum_{i=1}^n (x_i - \bar{x})(y_i - \bar{y})}{\sqrt{\sum_{i=1}^n (x_i - \bar{x})^2} \cdot \sqrt{\sum_{i=1}^n (y_i - \bar{y})^2}}$$

| Value | Interpretation |
|---|---|
| $r = 1$ | Perfect positive linear correlation |
| $r = -1$ | Perfect negative linear correlation |
| $r = 0$ | No linear correlation |
| $|r| > 0.7$ | Strong correlation (rule of thumb) |

---

## 4. Methods of Measuring Correlation

### Pearson Correlation

- **Type**: Parametric
- **Measures**: Linear relationship
- **Assumption**: Both variables are continuous and normally distributed
- **Formula**: See above
- **Use when**: Data is numeric and relationship is expected to be linear

### Spearman Rank Correlation

- **Type**: Non-parametric
- **Measures**: Monotonic relationship (not necessarily linear)
- **Works on**: Ranks of the data, not raw values

$$r_s = 1 - \frac{6 \sum d_i^2}{n(n^2 - 1)}$$

where $d_i = \text{rank}(x_i) - \text{rank}(y_i)$.

- **Use when**: Data is ordinal, skewed, or contains outliers.

### Kendall's Tau ($\tau$)

- **Type**: Non-parametric
- **Measures**: Ordinal association based on concordant/discordant pairs

$$\tau = \frac{(\text{concordant pairs}) - (\text{discordant pairs})}{\frac{1}{2} n(n-1)}$$

- **Use when**: Sample size is small, or data has many tied ranks.

### Point-Biserial Correlation

- Measures correlation between a **continuous** variable and a **binary** variable (e.g., 0/1).
- Mathematically equivalent to Pearson $r$ when one variable is binary.

### Comparison of Methods

| Method | Data Type | Assumption | Detects |
|---|---|---|---|
| Pearson | Continuous | Normal distribution | Linear |
| Spearman | Ordinal / Continuous | None (rank-based) | Monotonic |
| Kendall's Tau | Ordinal / Continuous | None (pair-based) | Ordinal association |
| Point-Biserial | Continuous + Binary | Normal (continuous var) | Linear |

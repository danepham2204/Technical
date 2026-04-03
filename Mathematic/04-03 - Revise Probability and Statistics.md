# 04/03 - Revise Probability & Statistics: The Science of Uncertainty

In Machine Learning, we almost never know anything with 100% certainty. We are always making educated guesses based on noisy data. Statistics gives us the math to measure how confident we should be in those guesses.

---

## 1. Random Variables & Distributions

**Step 1: What is a Random Variable?**
*   Unlike typical algebra where $x$ hides a specific fixed number (like $x = 5$), a **random variable** is an event where the outcome is subject to chance. 
*   **ML Context:** The height of the next person who walks into a room, or whether a user will click an ad, are random variables.

**Step 2: What is a Probability Distribution?**
*   A distribution is simply a "map" or a "menu" that shows all the possible outcomes of a random variable, and how likely each one is to happen.

**Step 3: Key Distributions in ML**
*   **Bernoulli Distribution:** The simplest distribution. It only has two outcomes: Success (1) or Failure (0). Think of a biased coin toss. 
    *   **ML Context:** This is the foundation of **Logistic Regression** and **Binary Classification** (e.g., predicting if an email is Spam or Not Spam).
*   **Gaussian (Normal) Distribution:** The famous "Bell Curve." It assumes most things gather around the middle (average), and rare things tail off to the sides.
    *   **ML Context:** Because of the *Central Limit Theorem*, naturally occurring noise almost always looks like a bell curve. Many ML algorithms strictly assume that the errors/residuals in your data follow a Gaussian distribution.

---

## 2. Expectation & Variance

**Step 1: Expectation (The Mean/Average)**
*   **What it is:** If you rolled a die infinitely many times, what would the average result be? That theoretical average is the "Expectation". 
*   **ML Context:** When training an ML model, we are trying to find the mathematical **Expected Value** of the Loss Function. We want our model to perform well "on average" across all possible future data.

**Step 2: Variance (The Spread)**
*   **What it is:** Variance measures how "spread out" the numbers are from the Expectation. (Standard Deviation is just the square root of Variance).
*   **ML Context:** In ML, high variance is a massive problem called **Overfitting**. It means your model is overly sensitive to random noise in your training data, causing its predictions to jump wildly when it sees new data. 

---

## 3. Bayes’ Theorem & Naïve Bayes

**Step 1: The Philosophy of Bayes' Theorem**
*   Most probability asks: *"Given the rules, what will happen?"* 
*   Bayesian probability asks: *"Given what just happened, what should I update my rules to be?"* It is the mathematics of changing your mind based on new evidence.

**Step 2: The Formula**
$$ P(A|B) = \frac{P(B|A) \times P(A)}{P(B)} $$
*   $P(A)$: Your initial belief (Prior).
*   $P(B|A)$: How likely the new evidence is, assuming your belief is true (Likelihood).
*   $P(A|B)$: Your new updated belief (Posterior).

**Step 3: Naïve Bayes Classifier**
*   **What it is:** A classic ML algorithm for text classification (like Spam Filtering). It uses Bayes' Theorem to calculate the probability that an email is spam, given the combination of words inside it.
*   **Why is it "Naïve"?** It assumes that every word appears independently of the others (e.g., seeing the word "Free" has no mathematical link to seeing the word "Money"). It's a "naïve" assumption, but it makes the math blazingly fast and surprisingly accurate.

---

## 4. Hypothesis Testing & p-values

**Step 1: The Core Problem**
*   You trained a new ML model, and it's 2% better than the old model. Is it actually smarter, or did it just get lucky on the test set? This is what Hypothesis Testing answers.

**Step 2: Null vs. Alternative Hypothesis**
*   **Null Hypothesis ($H_0$):** The default, skeptical position. *"Your new model is exactly the same as the old one; any difference is just random luck."*
*   **Alternative Hypothesis ($H_1$):** *"Your new model is actually fundamentally better."*

**Step 3: The p-value**
*   **What it is:** The probability of getting a result this weird (e.g., a 2% boost) *IF* the Null Hypothesis were completely true.
*   **How to read it:** If the p-value is extremely low (usually $< 0.05$), you can say: *"The chances of this happening by pure luck are less than 5%. Therefore, I reject the Null Hypothesis. My new model is genuinely better."* This is called **Statistical Significance**.

---

## 5. Interview Angle: Imbalanced Data

**Question:** *"How would you evaluate a classifier with imbalanced data?"*

**Step 1: Identify the trap (Accuracy)**
*   **Your Answer:** *"I would absolutely never use Accuracy. If we are predicting Credit Card Fraud, and 99% of transactions are normal, a completely useless 'dumb' model that just says 'Normal' every single time will be 99% accurate. But it fails at its actual job."*

**Step 2: Propose the Alternatives (Precision & Recall)**
*   *"Instead, I would look at the Confusion Matrix and focus on **Precision** and **Recall**, depending on the business problem."*
    *   **Precision:** Out of all the transactions the model *flagged* as fraud, how many were *actually* fraud? (Focuses on minimizing False Positives. Crucial for Spam Filters so you don't delete important emails).
    *   **Recall (Sensitivity):** Out of all the *real* frauds in the world, what percentage did our model successfully catch? (Focuses on minimizing False Negatives. Crucial for Cancer detection; missing a sick patient is worse than an accidental false alarm).

**Step 3: The Ultimate Metric (F1-Score or ROC-AUC)**
*   *"To get a single number that balances both, I would use the **F1-Score** (the harmonic mean of Precision and Recall). If I need to evaluate the model across many different thresholds, I would plot the **ROC Curve** and look at the **AUC (Area Under the Curve)** to see how well the model separates the classes."*

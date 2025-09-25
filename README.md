# MergeSort Report

## 1. Architecture Notes
- Implemented **MergeSort** using classic divide-and-conquer recursion.
- **Linear merge** with a reusable buffer to reduce memory allocations.
- **Small array cutoff**: for arrays smaller than a threshold, insertion sort is used to reduce recursion depth.
- **Metrics collection**:
  - `comparisons` counter to track the number of comparisons.
  - `maxDepth` to track the maximum recursion depth.
  - Execution time recorded in milliseconds (`time(ms)`).
- CSV output generated via `CSVWriter` for further analysis.

---

## 2. Recurrence Analysis
- MergeSort recurrence: `T(n) = 2T(n/2) + Θ(n)`
- **Master Theorem Case 2**:  
  - a = 2, b = 2, f(n) = Θ(n) → n^log_b(a) = n → f(n) = Θ(n log n)
- **Time Complexity**: Θ(n log n)
- **Space Complexity**: Θ(n) due to the reusable buffer.
- Cutoff to insertion sort reduces recursion depth slightly, improving constant factors.

---

## 3. Experimental Results

| n      | time (ms) | comparisons | maxDepth |
|--------|-----------|------------|----------|
| 10     | 5         | 28         | 1        |
| 100    | 0         | 642        | 4        |
| 1000   | 0         | 10247      | 7        |
| 5000   | 0         | 58670      | 10       |
| 10000  | 0         | 127096     | 11       |

**Observations:**
- Execution time is very small for small arrays; appears as 0 ms for larger arrays due to timer resolution, but the trend still grows with n log n.
- Maximum recursion depth grows roughly logarithmically with array size.
- Comparison counts increase with n, consistent with MergeSort’s Θ(n log n) behavior.

---

## 4. Summary
- MergeSort experimental results **align well with theoretical predictions**.
- Reusable buffer and insertion sort cutoff help reduce memory allocations and recursion overhead.
- Algorithm behaves as expected for both time and recursion depth, confirming efficiency and correctness.




# QuickSort Report

## 1. Architecture Notes
- **Algorithm:** Robust QuickSort  
- **Pivot Selection:** Randomized pivot  
- **Recursion Strategy:** Recurse on the smaller partition, iterate on the larger one to keep stack depth bounded  
- **Metrics Collected:** Execution time (ms), comparisons, maximum recursion depth  
- **Safety Features:** Small-n cut-off handled implicitly by recursion strategy to avoid deep stack calls  

---

## 2. Recurrence Analysis
- **Average Case:** Θ(n log n) — due to balanced partitioning with randomized pivot  
- **Worst Case:** Θ(n²) — occurs with highly unbalanced partitions, but randomized pivot reduces probability  
- **Recursion Depth:** Bounded by ~2 * log₂(n) for typical inputs  
- **Analysis Method:** Master Theorem intuition for divide-and-conquer; matches observed bounded recursion depth  

---

## 3. Benchmark Results

| n     | time (ms) | comparisons | maxDepth |
|-------|-----------|------------|----------|
| 10    | 0         | 30         | 1        |
| 100   | 0         | 608        | 4        |
| 1000  | 0         | 10306      | 7        |
| 5000  | 0         | 58516      | 10       |
| 10000 | 2         | 126884     | 11       |

**Observations:**  
- Execution time grows slowly for small arrays and increases noticeably at n = 10000.  
- Comparisons roughly follow n log n growth, consistent with theoretical expectations.  
- Maximum recursion depth increases logarithmically with n, confirming the bounded-stack strategy works.  
- Constant-factor effects (cache, GC) are minimal for small n; larger arrays start showing small overhead in time measurements.  

---

## 4. Summary
- **Alignment with Theory:** Metrics match Θ(n log n) expected for average case.  
- **Mismatch:** Minor timing differences due to measurement resolution and system effects.  
- Overall, QuickSort implementation is robust, recursion depth is controlled, and performance scales as expected.


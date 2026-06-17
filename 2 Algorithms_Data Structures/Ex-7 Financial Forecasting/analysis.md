## 4. Analysis

### Time Complexity

The recursive algorithm calculates the future value by calling itself once for each forecasting period until the base case is reached.

- **Time Complexity:** `O(n)`
  - The algorithm performs one recursive call for each period (`n`), resulting in linear time complexity.

- **Space Complexity:** `O(n)`
  - Each recursive call is stored in the call stack until the recursion completes, requiring linear stack space.

### Optimizing the Recursive Solution

Although the recursive approach is simple and easy to understand, it can become inefficient for a large number of forecasting periods due to the overhead of repeated function calls.

The recursive solution can be optimized by:

- **Memoization:** Store previously computed results so they can be reused instead of recalculating them.
- **Dynamic Programming:** Compute future values iteratively and store intermediate results, eliminating recursive calls.
- **Iterative Approach:** Replace recursion with a loop to reduce memory usage from `O(n)` stack space to `O(1)` auxiliary space while maintaining `O(n)` time complexity.

### Conclusion

The recursive algorithm is suitable for demonstrating the concept of financial forecasting and recursion. However, for large datasets or long forecasting periods, an iterative or dynamic programming approach is preferred because it reduces memory overhead and improves overall performance.
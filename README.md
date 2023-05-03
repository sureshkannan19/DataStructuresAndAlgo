<div>
<style>
	a {
      text-decoration: none;
   }
</style>
</div>

# DSA --  <a href="https://neetcode.io/roadmap">Neetcode</a> problem solving in Java

--------------------------------------------------------------------------------------------------------

**Arrays & Hashing:**

<table style="width:100%">
  <tr>
	<td>Sl No</td>
    <td>Question</td>
    <td>Answer</td>
    <td>Approach</td>
  </tr>
  <tr>
	<td>1</td>
    <td><a href="https://leetcode.com/problems/contains-duplicate/">ContainsDuplicate</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/ContainsDuplicate.java">ContainsDuplicate</a></td>
    <td>Iterate every element and add to hashset</td>
  </tr>
  <tr>
	<td>2</td>
    <td><a href="https://leetcode.com/problems/two-sum/">TwoSum</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/TwoSum.java">TwoSum</a></td>
    <td>Iterate and check for balance -> (target - input) in HashMap, if present return else add it to HashMap </td>
  </tr>
  <tr>
	<td>3</td>
    <td><a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/IsAnagram.java">Valid Anagram</a></td>
    <td>Use ASCII(0 to 128) --> iterate both source and target strings and add/remove chars in corresponding index and iterate if all chars from target at corresponding index is zero</td>
  </tr>
  <tr>
	<td>4</td>
    <td><a href="https://leetcode.com/problems/top-k-frequent-elements/">KFrequent Elements</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/KFrequentElements.java">KFrequentElements</a></td>
    <td>Iterate all elements and store its corresponding occurrence in countMap and sort(i.e PriorityQueue) based on its occurrence and poll till given 'K' frequent elements</td>
  </tr>
  <tr>
	<td>5</td>
    <td><a href="https://leetcode.com/problems/valid-sudoku/">Validate Sudoku</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/ValidateSudoku.java">ValidateSudoku</a></td>
    <td>Iterate all elements and store its corresponding occurrence in boolean[][] rows, cols, grid and check whether the index is already visited or not</td>
  </tr>
  <tr>
	<td>6</td>
    <td><a href="https://leetcode.com/problems/product-of-array-except-self/">Product of Array Except Self</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/ProductExceptSelf.java">ProductExceptSelf</a></td>
    <td>Iterate all elements and multiply all except zero and store in constant, iterate all elements again and divide current input with product</td>
  </tr>
  <tr>
	<td>7</td>
    <td><a href="https://leetcode.com/problems/group-anagrams/">Group Anagram</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/GroupAnagram.java">GroupAnagram</a></td>
    <td>ASCII representation of each chars in each string --> Iterate all elements and generate hashcode of all strings and group it in HashMap</td>
  </tr>
  <tr>
	<td>8</td>
    <td><a href="https://leetcode.com/problems/longest-consecutive-sequence/">Longest Consecutive Sequence</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/LongestConsecutiveSeq.java">LongestConsecutiveSeq</a></td>
    <td>Add all elements to HashSet and iterate all elements and check whether current input has any previous (i-1) input, if not it means its the begining of the sequence, hence iterate and search for (i+1) elements and update streak</td>
  </tr>
</table>
                   
--------------------------------------------------------------------------------------------------------
**Two Pointers:**

<table style="width:100%">
  <tr>
	<td>Sl No</td>
    <td>Question</td>
    <td>Answer</td>
    <td>Approach</td>
  </tr>
  <tr>
	<td>1</td>
    <td><a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum input array is Sorted</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/TwoSum.java">TwoSum</a></td>
    <td>Iterate array from both ends(left, right) and decrease/increase both ends based on the target</td>
  </tr>
  <tr>
	<td>2</td>
    <td><a href="https://leetcode.com/problems/3sum/">Three Sum</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/ThreeSum.java">ThreeSum</a></td>
    <td>Sort Array and loop outer array and Iterate inner array from both ends(left, right) and decrease/increase both ends based on the target</td>
  </tr>
  <tr>
	<td>3</td>
    <td><a href="https://leetcode.com/problems/valid-palindrome/">Valid Palindrome</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/ValidPalindrome.java">Valid Palindrome</a></td>
    <td>From charMap(new char[256]) and assign value for 0-9 and assign same value for charMap[i + 'a'] = charMap[i + 'A'] and 
    Iterate from both ends(left, right), skip if either left or right end value is zero</td>
  </tr>
  <tr>
	<td>4</td>
    <td><a href="https://leetcode.com/problems/container-with-most-water/">Container with Most water</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/MaxArea.java">MaxArea</a></td>
    <td>Iterate from both ends(left, right), get minimum value of between left and right, and multiply the distance between them.</td>
  </tr>
  <tr>
	<td>5</td>
    <td><a href="https://leetcode.com/problems/trapping-rain-water/description/">Trap rain water</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/TrapRainWater.java">TrapRainWater</a></td>
    <td>Iterate from both ends(left, right), store maximum value of left and right, if maxLeft <= maxRight, subtract (maxLeft -  height[left]), else  maxRight-height[right], and add it to result.</td>
  </tr>
</table>

--------------------------------------------------------------------------------------------------------
**Stack :**

<table style="width:100%">
  <tr>
	<td>Sl No</td>
    <td>Question</td>
    <td>Answer</td>
    <td>Approach</td>
  </tr>
  <tr>
	<td>1</td>
    <td><a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/ValidParentheses.java">ValidParentheses</a></td>
    <td>Iterate every element and add it to LinkedList.push(stack) if its open parentheses else poll last added open parentheses and validate</td>
  </tr>
  <tr>
	<td>2</td>
    <td><a href="https://leetcode.com/problems/min-stack/">Min stack</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/MinStack.java">MinStack</a> && <a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/MinStackViaNode.java">MinStackViaNode</a></td>
    <td>Store min value at each node level and return</td>
  </tr>
  <tr>
	<td>3</td>
    <td><a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">EvaluateReversePolishNotation</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/EvaluateReversePolishNotation.java">EvaluateReversePolishNotation</a></td>
    <td>Iterate and add operands to list and once encountered operators poll last two operands and do the operation.</td>
  </tr>
 </table> 
--------------------------------------------------------------------------------------------------------
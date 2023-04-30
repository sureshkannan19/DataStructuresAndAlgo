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

1. **TwoSum**: <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Question</a>
     & <a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/TwoSum.java">Answer</a>
     
 2. **ThreeSum**: <a href="https://leetcode.com/problems/3sum/">Question</a>
     & <a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/ThreeSum.java">Answer</a>
          
 3. **ValidPalindrome**: <a href="https://leetcode.com/problems/valid-palindrome/">Question</a>
     & <a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/ValidPalindrome.java">Answer</a>

4. **Container with most water**: <a href="https://leetcode.com/problems/container-with-most-water/">Question</a> & <a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/MaxArea.java">Answer</a>  
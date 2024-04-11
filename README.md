# Data Structures and Algorithms in Java

This repository contains a collection of Data Structures and Algorithms implemented in Java. It's a handy resource for anyone interested in problem-solving and algorithmic challenges. The solutions provided here cover a variety of topics, including arrays, hashing, two pointers, stacks, binary search, sliding windows, linked lists, and trees.

## Table of Contents
- [Sorting](#sorting)
- [Arrays & Hashing](#arrays--hashing)
- [Two Pointers](#two-pointers)
- [Stack](#stack)
- [Binary Search](#binary-search)
- [Sliding Window](#sliding-window)
- [Linked List](#linked-list)
- [Tree](#tree)

## sorting
<table style="width:100%">
  <tr>
    <td>Sl No</td>
    <td>Question</td>
    <td>Solution</td>
    <td>Approach</td>
  </tr>
  <tr>
    <td>1</td>
    <td>Selection Sort</td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/sort/SelectionSort.java">SelectionSort</a></td>
    <td>Select and swap -- Find Minimum in entire array and swap min value to first index 
    and current first index value to position where min value found, continue this for index+1 position(next minimum value) till n-1 of the array from left to right</td>
  </tr>
  <tr>
    <td>2</td>
    <td>Insertion Sort</td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/sort/InsertionSort.java">SelectionSort</a></td>
    <td>Find and swap -- Find Minimum between left and right, if found swap right to left</td>
  </tr>
</table>

## Arrays & Hashing

<table style="width:100%">
  <tr>
    <td>Sl No</td>
    <td>Question</td>
    <td>Solution</td>
    <td>Approach</td>
  </tr>
  <tr>
    <td>1</td>
    <td><a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/ContainsDuplicate.java">ContainsDuplicate</a></td>
    <td>Iterate through every element and add it to a HashSet.</td>
  </tr>
  <tr>
    <td>2</td>
    <td><a href="https://leetcode.com/problems/two-sum/">Two Sum</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/TwoSum.java">TwoSum</a></td>
    <td>Iterate and check for balance (target - input) in a HashMap; if present, return, else add it to the HashMap.</td>
  </tr>
  <tr>
    <td>3</td>
    <td><a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/arraysAndHashing/IsAnagram.java">Valid Anagram</a></td>
    <td>Use an ASCII array, iterate through both source and target strings, and add/remove chars in the corresponding index.</td>
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

## Two Pointers

<table style="width:100%">
  <tr>
    <td>Sl No</td>
    <td>Question</td>
    <td>Solution</td>
    <td>Approach</td>
  </tr>
  <tr>
    <td>1</td>
    <td><a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">Two Sum input array is Sorted</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/twopointers/TwoSum.java">TwoSum</a></td>
    <td>Iterate through the array from both ends (left and right) and adjust them based on the target.</td>
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
<tr>
	<td>5</td>
    <td><a href="https://leetcode.com/problems/daily-temperatures/">DailyTemperatures</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/DailyTemperatures.java">DailyTemperatures</a></td>
    <td><strong>Monotic Decreasing Stack Approach--></strong><br>
    Store first day temperature in stack<br>
    Iterate temperatures - check if current day temp is warmer than prev day, <br>
    if so pop current day temp from stack and diff btw them is result,<br>
    and store current day temperature in stack.
    update Stack on every iteration, that previous days are properly populated on corresponding index<br>
	<strong>Note:</strong> Stack will always have decreasing order of temp
    </td>
  </tr>
</table>

## Stack
<table style="width:100%">
  <tr>
    <td>Sl No</td>
    <td>Question</td>
    <td>Solution</td>
    <td>Approach</td>
  </tr>
  <tr>
    <td>1</td>
    <td><a href="https://leetcode.com/problems/valid-parentheses/">Valid Parentheses</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/ValidParentheses.java">ValidParentheses</a></td>
    <td>Iterate through every element, push it to the stack if it's an open parenthesis, or pop the last added open parenthesis and validate if it's a matching closing parenthesis.</td>
  </tr>
  <tr>
    <td>2</td>
    <td><a href="https://leetcode.com/problems/min-stack/">Min Stack</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/MinStack.java">MinStack</a> && <a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/MinStackViaNode.java">MinStackViaNode</a></td>
    <td>Store the minimum value at each node level and return it when needed.</td>
  </tr>
  <tr>
    <td>3</td>
    <td><a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">Evaluate Reverse Polish Notation</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/EvaluateReversePolishNotation.java">EvaluateReversePolishNotation</a></td>
    <td>Iterate through the tokens and perform the operations accordingly, using a stack to hold operands.</td>
  </tr>
  <tr>
    <td>4</td>
    <td><a href="https://leetcode.com/problems/generate-parentheses/">Generate Parentheses</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/GenerateParentheses.java">GenerateParentheses</a></td>
    <td>Use backtracking to generate valid parentheses by tracking the open and close parentheses counts.</td>
  </tr>
  <!-- Add similar structures for other problems in the "Stack" section -->
</table>

## Binary Search
<table style="width:100%">
  <tr>
    <td>Sl No</td>
    <td>Question</td>
    <td>Solution</td>
    <td>Approach</td>
  </tr>
  <tr>
    <td>1</td>
    <td><a href="https://leetcode.com/problems/binary-search/">Binary Search</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/binarysearch/BinarySearch.java">BinarySearch</a></td>
    <td>Search for the target in a sorted array using binary search by splitting/dividing the array in halves based on the mid value.</td>
  </tr>
  <tr>
    <td>2</td>
    <td><a href="https://leetcode.com/problems/search-a-2d-matrix/">Search in 2D Matrix</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/binarysearch/TwoDBinarySearch.java">TwoDBinarySearch</a></td>
    <td>Find the row where the target is located and apply binary search within that row.</td>
  </tr>
  <tr>
    <td>3</td>
    <td><a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Find Minimum in Rotated Sorted Array</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/binarysearch/MinimumRotatedSortedArray.java">MinimumRotatedSortedArray</a></td>
    <td>Find the minimum value in a rotated sorted array using binary search.</td>
  </tr>
  <!-- Add similar structures for other problems in the "Binary Search" section -->
</table>

## Sliding Window
<table style="width:100%">
  <tr>
    <td>Sl No</td>
    <td>Question</td>
    <td>Solution</td>
    <td>Approach</td>
  </tr>
  <tr>
    <td>1</td>
    <td><a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Longest Substring Without Repeating Characters</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/slidingwindow/LengthOfLongestSubstring.java">LengthOfLongestSubstring</a></td>
    <td>Use a sliding window approach to find the longest substring without repeating characters.</td>
  </tr>
  <tr>
    <td>2</td>
    <td><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Best Time to Buy and Sell Stock</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/slidingwindow/MaxProfit.java">MaxProfit</a></td>
    <td>Find the best time to buy and sell stock to maximize profit.</td>
  </tr>
  <tr>
    <td>3</td>
    <td><a href="https://leetcode.com/problems/fruit-into-baskets/">Fruit Into Baskets</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/slidingwindow/TotalFruit.java">TotalFruit</a></td>
    <td>Find the maximum number of fruits you can collect with two baskets.</td>
  </tr>
  </table>

## Linked List
<table style="width:100%">
  <tr>
    <td>Sl No</td>
    <td>Question</td>
    <td>Solution</td>
    <td>Approach</td>
  </tr>
  <tr>
    <td>1</td>
    <td><a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/ReverseLinkedList.java">ReverseLinkedList</a></td>
    <td>Iterate through the list to reverse its direction.</td>
  </tr>
  <tr>
    <td>2</td>
    <td><a href="https://leetcode.com/problems/merge-two-sorted-lists/">Merge Two Sorted Lists</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/MergeSortedLists.java">MergeSortedLists</a></td>
    <td>Merge two sorted linked lists into one sorted list.</td>
  </tr>
  <tr>
    <td>3</td>
    <td><a href="https://leetcode.com/problems/intersection-of-two-linked-lists/">Intersection of Two Linked Lists</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/IntersectionOfTwoLists.java">IntersectionOfTwoLists</a></td>
    <td>Find the node where two linked lists intersect.</td>
  </tr>
  <tr>
	<td>4</td>
    <td><a href="https://leetcode.com/problems/linked-list-cycle/">LinkedListCycle</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/LinkedListCycle.java">LinkedListCycle</a></td>
    <td>Floyd's Algorithm - Slow and Fast Pointer<br> 
    1. Initiate two pointers , where slow = head, fast = head.next<br> 
    2. Iterate slow pointer one by one(slow.next) and fast pointer as fast.next.next<br>
    3. at one stage both slow and fast pointer will meetup, then its a cycle<br>
    4. if fast pointer becomes null then the given list is not a cycle.</td>
  </tr>
  <tr>
	<td>5</td>
    <td><a href="https://leetcode.com/problems/lru-cache/">LRU Cache</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/LRUCache.java">LRUCache</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/LRUCacheViaLinkedHashMap.java">LRUCacheViaLinkedHashMap</a></td>
  </tr>
   <tr>
	<td>6</td>
    <td><a href="https://leetcode.com/problems/minimum-window-substring/">LRU Cache</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/MinimumWindowSubstring.java">MinimumWindowSubstring</a></td>
    <td></td>
  </tr>
</table>

## Tree

<table style="width:100%">
  <tr>
    <td>Sl No</td>
    <td>Question</td>
    <td>Solution</td>
    <td>Approach</td>
  </tr>
  <tr>
    <td>1</td>
    <td><a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum Depth of Binary Tree</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/tree/MaxDepth.java">MaxDepth</a></td>
    <td>Find the maximum depth of a binary tree using a recursive approach.</td>
  </tr>
  <tr>
    <td>2</td>
    <td><a href="https://leetcode.com/problems/symmetric-tree/">Symmetric Tree</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/tree/SymmetricTree.java">SymmetricTree</a></td>
    <td>Determine if a binary tree is symmetric by comparing its left and right subtrees.</td>
  </tr>
  <tr>
    <td>3</td>
    <td><a href="https://leetcode.com/problems/invert-binary-tree/">Invert Binary Tree</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/tree/InvertBinaryTree.java">InvertBinaryTree</a></td>
    <td>Invert a binary tree by swapping its left and right subtrees.</td>
  </tr>
  <tr>
	<td>4</td>
    <td><a href="https://leetcode.com/problems/balanced-binary-tree/">Balanced BT</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/trees/IsBalancedBinaryTreeViaRecursiveDFS.java">IsBalancedBinaryTreeViaRecursiveDFS</a></td>
    <td></td>
  </tr>
  <tr>
	<td>5</td>
    <td><a href="https://leetcode.com/problems/same-tree/">IsSameTree</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/trees/IsSameTree.java">IsSameTree</a></td>
    <td></td>
  </tr>
  <tr>
	<td>6</td>
    <td><a href="  https://leetcode.com/problems/subtree-of-another-tree/">IsSameSubTree</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/trees/IsSameSubTree.java">IsSameSubTree</a></td>
    <td></td>
  </tr>
</table>
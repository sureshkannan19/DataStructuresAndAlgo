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
    <td>Iterate and add operands to stack and once encountered operators (+, -, /, *) poll last two operands and do the operation.</td>
  </tr>
  <tr>
	<td>4</td>
    <td><a href="https://leetcode.com/problems/generate-parentheses/">GenerateParentheses</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/stack/GenerateParentheses.java">GenerateParentheses</a></td>
    <td><strong>Backtracking Approach--></strong><br>
    <strong>Basic Conditions:</strong><br>
    1. Valid Parentheses will have open and close Parentheses at left and right places<br>
    2. Open and close parentheses will be in equal count.<br>
    <strong>Steps:</strong><br>
    So append open parentheses at beginning and limit appending the parentheses based on given <strong>n - input</strong> <br>
    and recursively call the same backtracking helper method and generate parentheses, <br>and 
	reduce string length once the required size is reached.
   </td>
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
 
--------------------------------------------------------------------------------------------------------
**Binary Search :**

<table style="width:100%">
  <tr>
	<td>Sl No</td>
    <td>Question</td>
    <td>Answer</td>
    <td>Approach</td>
  </tr>
  <tr>
	<td>1</td>
    <td><a href="https://leetcode.com/problems/binary-search/">Valid Parentheses</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/binarysearch/BinarySearch.java">BinarySearch</a></td>
    <td>Search target in Sorted array is Binary Search, hence  <br> 
    keep splitting/dividing the sorted array by mid value, <br>
    if target is greater than nums[mid], then assign left to mid + 1<br>
    else assign right to mid - 1<br>
    Loop until left<=right <br></td>
  </tr>
  <tr>
	<td>2</td>
    <td><a href="https://leetcode.com/problems/search-a-2d-matrix/">Search in 2D Matrix</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/binarysearch/TwoDBinarySearch.java">TwoDBinarySearch</a></td>
    <td>Find the row where the target is, follow same approach used for Binary Search</td>
  </tr>
  <tr>
	<td>3</td>
    <td><a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Search in 2D Matrix</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/binarysearch/MinimumRotatedSortedArray.java">MinimumRotatedSortedArray</a></td>
    <td>Find the minimum of the array, by Binary Search approach </td>
  </tr>
 </table> 
 
--------------------------------------------------------------------------------------------------------
**Sliding Window:**


<table style="width:100%">
  <tr>
	<td>Sl No</td>
    <td>Question</td>
    <td>Answer</td>
    <td>Approach</td>
  </tr>
  <tr>
	<td>1</td>
    <td><a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">Length of the longest substring</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/slidingwindow/LengthOfLongestSubstring.java">LengthOfLongestSubstring</a></td>
    <td>1. Initiate HashSet or new int[128] and fill arrays with -1<br> 
    Once re-encountered the same character<br>
    Reset window start index by adding +1 to last occurred index, and <br>
    update last occurred character array index to current<br>
    and find max between window( end - start + 1) and update MaxStreak<br>
    </td>
  </tr>
  <tr>
	<td>2</td>
    <td><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">Max Profit</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/slidingwindow/MaxProfit.java">MaxProfit</a></td>
    <td>1. Start and Sell shares should be different days</br>
   </td>
  </tr>
   <tr>
	<td>3</td>
    <td><a href="https://leetcode.com/problems/longest-repeating-character-replacement/">Length of the longest substring</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/slidingwindow/LongestRepeatingCharacter.java">LongestRepeatingCharacter</a></td>
    <td>Initiate array new int[26], maxCharCount, maxCount<br> 
    Increment char count using ASCII index and update maxCharCount<br>
    Decrement charCount-> when the window (right -left) - maxCharCount is > k(noOfCharacterReplacementAllowed) and<br>
    increment left index<br>
    and find max between window( right - left + 1) and update maxCount<br>
    </td>
  </tr>
 </table> 
 
 ---------------------------------------------------------------------------------------------------------
 
**Linked List:**


<table style="width:100%">
  <tr>
	<td>Sl No</td>
    <td>Question</td>
    <td>Answer</td>
    <td>Approach</td>
  </tr>
  <tr>
	<td>1</td>
    <td><a href="https://leetcode.com/problems/reverse-linked-list/">Reverse LinkedList</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/ReverseLinkedList.java">ReverseLinkedList</a></td>
    <td>Iterate until currentNode become empty<br> 
    1. getAndStore next value in a variable(nextElement)<br> 
    2. set current.next as previous<br>
    3. set previous value as current<br> 
    4. store current as = nextElement<br>
    </td>
  </tr>
  <tr>
	<td>2</td>
    <td><a href="https://leetcode.com/problems/merge-two-sorted-lists/">MergeTwoSortedLists</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/MergeTwoSortedLists.java">MergeTwoSortedLists</a></td>
    <td>Iterate until both list becomes empty<br> 
    1. find lowest value between both list and store in result<br> 
    2. pop result = result.next on end of every iteration<br>
    </td>
  </tr>
  <tr>
	<td>3</td>
    <td><a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">RemoveNthNodeAtEndOfList</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/linkedlist/RemoveNthNodeAtEndOfList.java">RemoveNthNodeAtEndOfList</a></td>
    <td>To stop/find the nth position from the end of the list, we need two pointer approach<br> 
    1. Initiate dummy node with head, and Move right pointer to n times, and delay left pointer(do not move left ptr)<br> 
    2. Once right pointer shifted to n times, move both left and right pointer one by one<br>
    3. at one stage right pointer will become null and left pointer will be at the n - 1th position from the end<br>
    4. now set left.next as left.next.next</td>
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
 </table> 
 
 
 ---------------------------------------------------------------------------------------------------------
 
**Tree:**


<table style="width:100%">
  <tr>
	<td>Sl No</td>
    <td>Question</td>
    <td>Answer</td>
    <td>Approach</td>
  </tr>
  <tr>
	<td>1</td>
    <td><a href="https://leetcode.com/problems/invert-binary-tree/">Invert BinaryTree</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/trees/InvertBinaryTree.java">InvertBinaryTree</a></td>
    <td></td>
  </tr>
  <tr>
	<td>2</td>
    <td><a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">Maximum depth of BT</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/trees/FindDepthofBinaryTreeViaRecursiveDFS.java">FindDepthofBinaryTreeViaRecursiveDFS</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/trees/FindDepthOfBinaryTreeViaIterativeDFS.java">FindDepthOfBinaryTreeViaIterativeDFS</a></td>
  </tr>
  <tr>
	<td>3</td>
    <td><a href="https://leetcode.com/problems/diameter-of-binary-tree/">Diameter of BT</a></td>
    <td><a href="https://github.com/sureshbabk19698/DataStructuresAndAlgo/blob/main/src/main/java/org/sk/trees/DiameterOfTheBinaryTree.java">DiameterOfTheBinaryTree</a></td>
    <td></td>
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
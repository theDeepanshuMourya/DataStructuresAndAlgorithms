[![Gitpod ready-to-code](https://img.shields.io/badge/Gitpod-ready--to--code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/theDeepanshuMourya/DataStructuresAndAlgorithms)

# DataStructuresAndAlgorithms
This is a collection of algorithms and data structures which I've implemented from scratch as well as using inbuilt libraries in Java along with some famous Dynamic Programming Problems.

You can run and edit the algorithms or contribute to them using [Gitpod.io](https://gitpod.io/), a free online development environment, with a single click.

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/theDeepanshuMourya/DataStructuresAndAlgorithms)

# Contributing
1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request :smile:

# What's been implemented:
## Data Structures
  - Lists
    - [Arraylists](/src/lists/ArrayLists)
    - [Singly LinkedList](/src/lists/SinglyLinkedList)
    - [Doubly LinkedList](/src/lists/DoublyLinkedList)
    - [JDK LinkedList](/src/lists/JDKLinkedList)  
  - Stacks
    - [Array Implementation](/src/stacks/Array)
    - [LinkedList Implementation](/src/stacks/LinkedList)
  - Queues
    - [Array Implementation](/src/queue/Array)
    - [Circular Queues](/src/queue/Circular)    
  - Hashtable
    - [Hashtable with Chaining](/src/hashtable/Chaining)
    - [Hashtable with Linear Probing](/src/hashtable/LinearProbing)
    - [JDK Hashtable](/src/hashtable/JDK)    
  - Trees
    - [Binary Search Trees](/src/tree/BinarySearchTrees)
  - Heaps
    - [Max Heap](/src/heap/MaxHeap)
    - [JDK Priority Queue](/src/heap/JDKPriorityQueue)
    
## Sorts
  - [Bubble Sort](/src/sorts/BubbleSort.java)
  - [Bucket Sort](/src/sorts/BucketSort.java)
  - [Heap Sort](/src/sorts/HeapSort.java)
  - [Insertion Sort](/src/sorts/InsertionSort.java)
  - [Merge Sort](/src/sorts/MergeSort.java)
  - [Quick Sort](/src/sorts/QuickSort.java)
  - [Selection Sort](/src/sorts/SelectionSort.java)
  - [Shell Sort](/src/sorts/ShellSort.java)
  
## Algorithms
  - Graphs
    - Graph Traversal
      - [Breadth First Search](/src/graphs/Traversal/BreadthFirstSearch.java)
      - [Depth First Seach](/src/graphs/Traversal/DepthFirstSearch.java)
      - [Bipartite Graph](/src/graphs/Traversal/BipartiteGraph.java)
    - Cycle detection
      - [Depth first search while keeping track of visited Verticies](/src/graphs/CycleDetection/DFSCycleDetection.java)
    - Find shortest path in a Graph from a starting Vertex
      - [Dijkstra's algorithm (non-negative weight graphs)](/src/graphs/ShortestPathAlgorithms/DijkstraAlgorithm.java)
      - [DAG Shortest Path](/src/graphs/ShortestPathAlgorithms/DAGShortestPath.java)
      - [Bellman-Ford algorithm (negative and positive weight graphs)](/src/graphs/ShortestPathAlgorithms/BellmanFordAlgorithm.java)
    - [Topological sort](/src/graphs/Sorting/TopologicalSort.java)
    - Find minimum spanning tree
      - [Kruskal's (undirected graphs)](/src/graphs/MinimumSpanningTrees/KruskalAlgorithm.java)
      - [Prim's (undirected graphs)](/src/graphs/MinimumSpanningTrees/PrimsAlgorithm.java)
    - Find Strongly Connected Components
      - [Kosaraju's Algorithm](/src/graphs/StronglyConnectedComponents/KosarajuAlgorithm.java)
      - [Tarjan's Algorithm](/src/graphs/StronglyConnectedComponents/TarjanAlgorithm.java)
    - Maximum Flow
      - [Ford Fulkerson's Algorithm](/src/graphs/MaximumFlow/FordFulkersonAlgorithm.java)
      - [Minimum s-t cut in Flow Network](/src/graphs/MaximumFlow/MinCut.java)
    - Hard Problems
      - [Travelling Salesman Problem (Naive Approach)](/src/graphs/HardProblem/TravellingSalesmanProblem.java)
    
  - Searching
    - [Linear Search](/src/searching/LinearSearch.java)
    - [Binary Search](/src/searching/BinarySearch.java)
    
## Dynamic Programming
  - [Boolean Parenthesization](/src/dynamicProgramming/BooleanParenthisaztion.java)
  - [Box Stacking](/src/dynamicProgramming/BoxStacking.java)
  - [Coin Change](/src/dynamicProgramming/CoinChange.java)
  - [Count Binary Strings Without Adjacent Ones](/src/dynamicProgramming/CountBinaryStringWithoutAdjacentOnes.java)
  - [Edit Distance](/src/dynamicProgramming/EditDistance.java)
  - [Egg Dropping Puzzle](/src/dynamicProgramming/EggDroppingPuzzle.java)
  - [Knapsack Problem](/src/dynamicProgramming/KnapSack.java)
  - [Knight Probability in Chess board](/src/dynamicProgramming/KnightChessProbability.java)
  - [Longest Bitonic Subsequence](/src/dynamicProgramming/LongestBitonicSubsequence.java)
  - [Longest Common Subsequence](/src/dynamicProgramming/LongestCommonSubsequence.java)
  - [Longest Increasing Subsequence](/src/dynamicProgramming/LongestIncreasingSubsequence.java)
  - [Longest Palindromic Subsequence](/src/dynamicProgramming/LongestPalindromicSubsequence.java)
  - [Matrix Chain Multiplication](/src/dynamicProgramming/MatrixChainMultiplication.java)
  - [Maximum Length Chain Pairs](/src/dynamicProgramming/MaxLengthChain.java)
  - [Maximum Sum Increasing Subsequence](/src/dynamicProgramming/MaximumSumIncreasingSubsequence.java)
  - [Minimum Jumps to reach End](/src/dynamicProgramming/MinJumpToReachEnd.java)
  - [Minimum Path Sum](/src/dynamicProgramming/MinimumPathSum.java)
  - [Optimal Game Strategy](/src/dynamicProgramming/OptimalGameStrategy.java)
  - [Pattern Matching](/src/dynamicProgramming/PatternMatching.java)
  - [Shortest Common Supersequence](/src/dynamicProgramming/ShortestCommonSupersequence.java)

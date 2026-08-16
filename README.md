# practiceLeetcode

A personal repository for practicing LeetCode problems and algorithm/data-structure exercises.

## Overview
This repo collects solved LeetCode problems (and drafts) organized by language and topic. Solutions are kept small, focused, and runnable from an IDE or command line where applicable.

## How to use
- Open the project in your IDE (IntelliJ IDEA) and run individual solution classes or test files.
- Each problem folder contains a solution file (e.g., Solution.java / solution.py) and a short README when needed.
- Follow naming conventions described below when adding new problems.

## Conventions
- Folder name: <problem-number>-<problem-slug> (e.g., 1-two-sum)
- Files inside each problem folder:
  - Solution.java or solution.py (primary implementation)
  - Main.java or run.py (optional runnable example)
  - README.md (brief notes, time/space complexity)

## Folder structure
Top-level layout (example):

practiceLeetcode/
├─ .idea/                      # IDE project files (ignored in VCS)
├─ src/
│  └─ main/
│     └─ java/
│        └─ leetpractice/      # Primary Java package for solutions
│
├─ tests/                      # Unit tests (optional)
├─ README.md                   # This file


## Adding a new solution
1. Create a new folder following the convention: `NN-problem-slug`.
2. Add the solution file named by language (Solution.java, solution.py).
3. Include a short README with complexity notes and any special considerations.
4. (Optional) Add unit tests under `tests/` referencing the new solution.

## Notes
- Keep solutions focused and well documented with time/space complexity.
- Prefer clear, idiomatic language constructs for readability over clever one-liners.

## License
This repository is for personal practice. Use freely for learning and reference.

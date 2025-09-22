I implimented 4/6 of the checks in category A: CommentCount, LoopCount, ExpressionCount, and OperatorCount.

The criteria for CommentCount was each // or /*, and I assumed each started comment was finished and that no comments // like // this // one existed.

For LoopCount, it was any instance of for, foreach, or while.

ExpressionCount was any line with one or more of +, -, /, %, or \*. I did not look for = in case there was something like if(x\*y). I also only counted the regular arithmatic expressions with this.

OperatorCount counted each of these: +, -, *, /, %, ==, ++, --, !=, >>>, <<<, >, <, >=, <=, ^, |, ||, &&, ^=, +=, -=, /=, *=, %=, >>>=, |=, ||=.
- Notably, I am unsure why it didn't recognize i++ as an instance of an operator, but the loop, comment, and expression counts were correct otherwise in the HelloWorld file, and it did fine in my BinarySearch.

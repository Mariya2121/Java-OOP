## Exceptions And Error Handing

1. What are Exceptions in Java ?
- Exceptions са механизъм, чрез който оправляваме непредвидено поведение в нашата програма, което се е случило
по време на изпълнение на програма
- Exceptions handle errors and problem at runtime
- Throw an exception to signal about a problem
- Когато използваме exceptions можем да ги използваме по такъв начин, че да върнем отговор на потребителите на кода
на различни нива. Exceptions могата да отидат на различни нива, затова използваме клучовата дума throw. Throw е просто един обект.

``` 
if (size < 0)
  throw new Exception("Size cannot be negative!");
```
- Catch an exception to handle the problem
- Try-Catch -> олавя exceptions
## More about Exceptions
- Exceptions occur when the normal flow of the program is interrupted due to problem (or error)
  * When an operation fails to execute at runtime
  * Example: trying to read a non-existing file
- Exceptions allow the problematic situations to be handled at multiple levels -> Simplify code construction and maintenance
- Exception objects hold detailed information about the error: error message, stack trace, etc.

2.Throwable class - базови клас за всички видове exceptions
- Exceptions in Java are objects 
- The Throwable class is a base for all Java exceptions:
  * Contains information for the cause of the problem
  * Message – a text description of the exception
  * StackTrace – the snapshot of the "call stack" at the moment when the exception is throws

3. Types of Exceptions in Java
- All Java exceptions inherit from java.lang.Throwable
- Direct descendants of Throwable:
  * Error – not expected to be caught from the program under normal circumstances
    * Examples: StackOverflowError, OutOfMemoryError
  * Exception
    * Used for exceptional conditions that user programs could catch
    * Examples: ArithmeticException, IOException

- Exceptions are 2 types:
- Checked – an exceptions that should be obligatory handled -> checked by the compiler during the compilation
  * Also called compile-time exceptions
- Unchecked – exceptions that occur at the time of execution
  * Also called runtime exceptions, not obligatory handled
![img.png](../../../ExceptionsAndErrorHanding/src/img.png)
# Accounting App -  Unit Testing

Implements and tests `Accounting.projectWeeklyCost(Project)` that respects the following constraints:
 * Every employee gets a bonus of 100 AUD fortnightly for every project.
 * A project has a fix daily cost of 25 AUD with less than 5 members and 30 AUD after
 
Each test criteria is an independent test method and named as specified in naming convention below.

Initialize the test object with `setUp` method.


### Naming Convention
The following naming convention has been used for tests:

```
MethodName_ExpectedBehavior_StateUnderTest
```

For example:
```
isValid_False_IfMandatoryFieldsMissing
calculateBonus_ThrowsException_IfNotValidEmployee
```

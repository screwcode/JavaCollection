# ScrewCode - Java Collection 

[回到首页](https://github.com/screwcode/JavaCollection)

## 修复Bug: 修复`IncrementalList`在并发环境下的问题

小明写了一个`IncrementalList`类，但是在并发环境下有问题，测试没有通过。

请修复`src/main/java/Incremental.java`中的bug，使得测试通过（`mvn test`），然后提交Pull Request。
切记，Pull Request的base分支一定要选择`FixIncrementalListConcurrentIssue`！

![1](https://raw.githubusercontent.com/screwcode/SumOfTwoIntegers/master/images/compare-pr.png)
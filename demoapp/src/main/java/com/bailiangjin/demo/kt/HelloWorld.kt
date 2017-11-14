package com.bailiangjin.demo.kt
/**
 * TODD:添加类注释
 *
 * @author  bailiangjin
 *
 * @date    2017/11/14
 */
class HelloWorld() {
   fun greet() {
        print("Hello")
    }

    fun main(args: Array<String>) {    // 包级可见的函数，接受一个字符串数组作为参数
        println("Hello World!")         // 分号可以省略
    }
}
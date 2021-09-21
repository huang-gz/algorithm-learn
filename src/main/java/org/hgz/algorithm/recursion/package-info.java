package org.hgz.algorithm.recursion;


// 递归 - 循环
// 通过函数体来进行的循环

/**
 * 1. 向下进入到不同的递归层; 向上又回到原来的那一层, 一层一层下一层一层回来
 * 2. 用参数不同不曾传递变量
 * 3. 每一层都是拷贝
 *
 * public recursion(leve, param, pram'...)
 *  # 1recursion terminator 递归终结者
 *  if  level > max_level:
 *      process result
 *  return
 *
 *  # 2process logic current level
 *  处理当前层逻辑
 *  process (leve, data...)
 *
 *  3 drill down 递归调用
 *  self.recursion(lvel+1, p1....)
 *
 *  # 4 reverse
 *  清扫当前层
 *
 *
 *
 * 不要人肉递归, 递归的状态树画出来,后面要抛弃人肉递归, 和画递归状态树
 * 找到最近最简方法, 最近重复子问题
 * 数学归纳法, n ==1 n==2 时成立, n成立 n+1 也成立
 *
 **/
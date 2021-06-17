package br.com.knowledge.tailrecfunction

import java.math.BigInteger

// a palavra tailrec funciona para métodos recursivos que precisam resolver números grandes
tailrec fun getFibonacciNumber(n: Int, a:BigInteger, b: BigInteger): BigInteger{
    if(n == 0)
        return b
    else
        return getFibonacciNumber(n-1, a+b, a)

}

 fun main() {
    print(getFibonacciNumber(10000, BigInteger("1"), BigInteger("0")))
}
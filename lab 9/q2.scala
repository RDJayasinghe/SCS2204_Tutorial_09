object q2 extends App {

    def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    def lcm(a: Int, b: Int): Int = (a * b) / gcd(a, b)
    

    class Rational(numerator: Int, denominator: Int = 1) {
        if (denominator == 0) {
            println("Denominator cannot be Zero")
            sys.exit(100)
        }

        val num: Int = numerator
        val den: Int = denominator

        def display(): String = num + "/" + den
    }

    def sub(a:Rational, b:Rational): Rational = {

        var den2 = lcm(a.den, b.den)
        var num2 = a.num*(den2/a.den) - b.num*(den2/b.den)

        new Rational(num2, den2)
    }

    var x = new Rational(3, 4)
    println(x.display())
    
    var y = new Rational(5, 8)
    println(y.display())

    var z = new Rational(2, 7)
    println(z.display())

    var diff = sub(sub(x, y), z)
    println(diff.display())
}
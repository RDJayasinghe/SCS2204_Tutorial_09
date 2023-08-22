object q1 extends App {
    class Rational(numerator: Int, denominator: Int = 1) {
        if (denominator == 0) {
            println("Denominator cannot be Zero")
            sys.exit(100)
        }

        val num: Int = numerator
        val den: Int = denominator

        def neg(): Rational = new Rational(-num, den)

        def display(): String = {
            if(denominator != 1) {
                num + "/" + den
            } else {
                num + ""
            }
        }
    }

    var x = new Rational(3, 4)
    println(x.display())
    x = x.neg()
    println(x.display())

}
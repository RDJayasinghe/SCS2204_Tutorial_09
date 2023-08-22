object q4 extends App {

    class Account(acc_name: String, acc_balance: Double = 0.0) {
        
        val name: String = acc_name
        var balance: Double = acc_balance
        var interest:Double = 0
        
        def Deposit(amount:Double)  = {
            balance += amount
        }

        def Withdraw(amount:Double) = {
            if(amount > balance) println("Insufficient Balance")
            else balance -= amount
        }

        def Transfer(other_acc:Account, amount:Double) = {
            if(amount > balance) println("Insufficient Balance")
            else {
                this.Withdraw(amount)
                other_acc.Deposit(amount)
            }
        }

        def calc_interest() = {
            if(this.balance > 0) {
                this.interest = 0.05*this.balance
                this.balance += this.interest
            } else if(this.balance < 0) {
                this.interest = 0.1*(this.balance.abs)
                this.balance -= this.interest
            }
        }

        def display() = {
            println("Name : " + this.name)
            println("Balance: " + this.balance + "\n")
        }
    }

    val bank = List(new Account("Ramindu", 10000), new Account("Dulmin", -500.00), new Account("Kasun", -200))

    println("List of Accounts with Negative Balances")
    bank(0).display()
    bank(1).display()
    bank(2).display()

    var counter: Int = 0
    var total_balance: Double = 0
    while(counter < bank.length) {
        total_balance += bank(counter).balance
        counter += 1
    }
    println("Total Balance : " + total_balance + "\n")

    println("\nAfter Interest is calculated")
    bank(0).calc_interest()
    bank(1).calc_interest()
    bank(2).calc_interest()

    bank(0).display()
    bank(1).display()
    bank(2).display()

}
import java.net.DatagramSocketImplFactory;
import java.util.Scanner;

class LessbalanceException extends Exception {
LessbalanceException(double amt)
{
    System.out.println("Withdrawing"+amt+"is invalid");
}
 }
 class User{
    String name;
    User(String name){
        this.name=name;
    }
    class Account{
        int acc_no;
        double bal;
Account(int acc_no,double bal){
this.acc_no=acc_no;
this.bal=bal;
    }
 }
 Account[] a=new Account[2];

 void deposite(double amt,int a_no){
int found=0,k=-1;
for(int i=0;i<2;i++){
    if(a[i].acc_no==a_no){
        a[i].bal+=amt;
        found=1;
        k=i;
        break;
    }
    if(found==1)
{
    System.out.println("Balance Updated:");
    display(a[k].acc_no);
}
else
System.out.println("Account no does not exist:");
}
 }

Void withdrawal(double amt,int acc_no)throws LessbalanceException{
    int k=-1;
    int found=0;
    for(int i=0;i<2;i++)
    if(a[i].acc_no==acc_no){
        k=i;
        found=1;
        break;
        if(found==1)
{
    if((a[i].bal<500)||( a[k].bal<amt))
    throw new LessbalanceException(amt);
    else{
        a[k].bal=amt;
        display(a[k].acc_no);
    }
    }
    else
    System.out.println("Account no does not exist:");
}   
} 
 
void create_account()
    {
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<2;i++){
            System.out.println("Enter the account no:");   
            int acc_no=sc.nextInt();
            System.out.println("Enter balance:");
            double bal=sc.nextDouble();
            a[i]=new Account(acc_no, bal);

        }

    }
void display(int acc_no)
{
    int k=-1,found=0;
    for(int i=0;i<2;i++)
    if(a[i].acc_no==acc_no){
        k=i;
        found=1;
        break;
    }
    if(found==1){
        System.out.println("------------------Account Details-------------");
        System.out.println(name+"\t"+a[k].acc_no+"\t"+a[k].bal);
        System.out.println("------------------------------------------------");
    }
}
}
    

public class bankDemo {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("CREATE ACCOUNT WITH MINIMUM BALANCE:");
    System.out.println("Enter owner name:");
    String name=sc.next();
    int acc_no;
    User u=new User(name);
    u.create_account();
    System.out.println("Account created successfully:");
    boolean opt=true;
    while(opt){
        System.out.println("===========================================");
        System.out.println("1.BALANCE ENQUIRY 2.DEPOSIT 3.WITHDRAWAL ");
        System.out.println("=========================================");
        System.out.println("Enter your name:");
        int ch=sc.nextInt();
        switch(ch){
            case 1:System.out.println("Your account details:");
                      System.out.println("Enter account number:");
                      acc_no=sc.nextInt();
                      u.display(acc_no);
                      break;
        case 2:System.out.println("Enter account no:");
                      acc_no=sc.nextInt();
                      System.out.println("Enter amount to deposite:");
                      Double amt=sc.nextDouble();
                      u.deposite(amt, acc_no);
                      break;         
    case 3:try{
                System.out.println("Enter account no:");
                acc_no=sc.nextInt();
                      System.out.println("Enter amount to withdrawal:");
                      double amt=sc.nextDouble();
                      u.withdrawal(amt, acc_no);
    }catch(LessbalanceException e){}
                      break;
        }
    }
    }
}

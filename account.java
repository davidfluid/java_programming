import java.io.*;  
import java.util.*;

class account{
String acc_name, date, branch;
long acc_no, cont_no;
static float acc_balance = 500.0f, acc_deposit, acc_withdraw;

void disp(String a, long b, String c, String d, long e){
acc_name = a;
acc_no = b;
date = c;
branch = d;
cont_no = e;

System.out.println(" ");
System.out.println("Account name: "+acc_name);
System.out.println("Account number: "+acc_no);
System.out.println("Date of transaction: "+date);
System.out.println("Branch name: "+branch);
System.out.println("Mobile number: "+cont_no);
System.out.println("Present account balance: "+acc_balance);
}

float deposit1(float bal, float dep){
acc_balance = bal + dep;
return acc_balance;
}

float widthdraw2(float bal, float with){
acc_balance = bal - with;
return acc_balance;
}

public static void main(String args[]) throws java.io.IOException{
int option;
int count = 0;
int max_no = 10; // max. permissible counts is set to be 10
String a, c, d;
long b, e;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
Scanner ob = new Scanner(System.in); //System.in is a standard input stream
account cust1 = new account(); // cust1 object in class named account

System.out.print("Enter Account holder's name: ");  
a= br.readLine();  //Account Name

System.out.print("Enter Account number: ");  
b= Long.parseLong(br.readLine());  //Account Number

System.out.print("Enter Date of Transaction: ");  
c= br.readLine();  //Date of Transaction

System.out.print("Enter Branch name: ");  
d= br.readLine();  //Branch name

System.out.print("Enter mobile number: ");  
e= Long.parseLong(br.readLine());  //Mobile number

cust1.disp(a,b,c,d,e);

do{
do {
count++;
System.out.println("\n\n****Thanks for banking****");
System.out.println("Enter your preference:");
System.out.println("1-->Deposit");
System.out.println("2-->Withdrawal");
System.out.println("3-->End transaction");
option = System.in.read();
}while(option==1 || option==2);

switch(option){
case '1':
System.out.println("1. Deposit option selected");
System.out.println("\n\nEnter the amount to deposit: INR. ");
acc_deposit = ob.nextFloat();

if(acc_deposit>50000){
System.out.println("\n\nThe deposit cannot be greater than INR. 50000");
System.out.println("Enter ctrl + c to end the transaction.");
System.out.println("Enter the alternate deposit amount. INR. :");
acc_deposit = ob.nextFloat();
acc_balance = cust1.deposit1(acc_balance, acc_deposit);
System.out.println("\n\nThe present account balance: INR. "+acc_balance);
break;
}

else{
acc_balance = cust1.deposit1(acc_balance, acc_deposit);
System.out.println("\n\nThe present account balance: INR. "+acc_balance);
break;
}

case '2':
System.out.println("2. Withdrawal option selected");
System.out.println("\n\nEnter the amount to withdraw: INR. ");
acc_withdraw = ob.nextFloat();
acc_balance = cust1.widthdraw2(acc_balance, acc_withdraw);

if(acc_withdraw<10000){
if(acc_balance <500){
System.out.println("Present account balance: INR. "+(acc_balance+acc_withdraw));
System.out.println("\n\nThe account balance cannot be lesser than INR. 500");
System.out.println("Transaction declined.");
count += max_no; // max. permissible counts is set to be 10
break;
}

else{
System.out.println("Present account balance: INR. "+acc_balance);
break;
}
}

else
{
System.out.println("Maximum withdrawable amount per day is : INR. 10,000");
System.out.println("Present account balance: INR. "+(acc_balance+acc_withdraw));
System.out.println("Transaction declined.");
count += max_no; // max. permissible counts is set to be 10
break;
}

case '3':
count += max_no; // max. permissible counts is set to be 10
System.out.println("\n\nThe present account balance: INR. "+acc_balance);
break;

default:
System.out.println("Invalid entry. Transaction declined.");
System.out.println("\n\nThe present account balance: INR. "+acc_balance);
count += max_no; // max. permissible counts is set to be 10
break;
}//switch(option)
}while(count<max_no); // max. permissible counts is set to be 10
}//main()
}//class

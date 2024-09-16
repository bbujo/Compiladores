using System;using System.IO;public class MainClass{  public static void Main(string[] args){ double  a;
double  b;
double  c;
string  d;
double  v;
Console.WriteLine("Digite A");
a= Convert.ToDouble(Console.ReadLine());
Console.WriteLine("Digite B");
b= Convert.ToDouble(Console.ReadLine());
if (a<b) {c = a+b;}else {c = a-b;}
if (a<b) {c = a*b;}
while (a>b) {b = b/1;}
Console.WriteLine("C e igual a ");
Console.WriteLine(c);
d = "exemplo";
c = 4.95;
switch (d) {case "exemplo":c = 3;break;default:c = 2;break;}
switch (c) {case 1:c = 3;break;case 2:c = 2;break;case 3:c = 1;break;}
Console.WriteLine("D e igual a ");
Console.WriteLine(d);
 }}
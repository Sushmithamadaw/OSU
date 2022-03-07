#include<stdio.h>
void main()
{
int incoming,outgoing,buff_size,n,store=0,result;
printf("Enter the no of packets:\n");
scanf("%d",&n);
printf("Enter buff_size:\n");
scanf("%d",&buff_size);
printf("Enter outgoing:\n");
scanf("%d",&outgoing);
while(n!=0)
{
printf("Enter the incoming packets:");
scanf("%d",&incoming);

if(incoming<=(buff_size-store))
{
store+=incoming;
}
else
{
result= (incoming-(buff_size-store));
printf("Dropped pakkets %d\n",result);
store=buff_size;
printf("Bucket buffer size %d out of %d\n",store,buff_size);
}
store=store-outgoing;
n--;
}
}

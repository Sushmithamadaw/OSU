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
printf("Incoming packet size %d\n",incoming);
if(incoming<=(buff_size-store))
{
store+=incoming;
printf("Bucket buffer size %d out of %d\n",store,buff_size);
}
else
{
result= (incoming-(buff_size-store));
printf("Dropped pakkets %d\n",result);
printf("Bucket buffer size %d out of %d\n",store,buff_size);
store=buff_size;
}
store=store-outgoing;
printf("After out going %d packets out of %d buffer\n",store,buff_size);
n--;
}
}

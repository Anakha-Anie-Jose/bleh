var a=prompt("Enter a string")
var count=0

for(i=0,j=a.length-1;i<a.length,j>0;i+=1,j--)
{
if( a[i]!=a[j]){
count+=1
}
}
if( count==0)
{
  console.log("Yes")  
}
else
{
    console.log("No")
}
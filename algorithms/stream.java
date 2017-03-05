/*
  learning to use stream of java 8
*/
//清单 1. Java 7 的排序、取值实现
List<Transaction> groceryTransactions = new Arraylist<>();
for(Transaction t: transactions){
 if(t.getType() == Transaction.GROCERY){
 groceryTransactions.add(t);
 }
}
Collections.sort(groceryTransactions, new Comparator(){
 public int compare(Transaction t1, Transaction t2){
 return t2.getValue().compareTo(t1.getValue());
 }
});
List<Integer> transactionIds = new ArrayList<>();
for(Transaction t: groceryTransactions){
 transactionsIds.add(t.getId());
}
//而在 Java 8 使用 Stream，代码更加简洁易读；而且使用并发模式，程序执行速度更快。
//清单 2. Java 8 的排序、取值实现
List<Integer> transactionsIds = transactions.parallelStream().
 filter(t -> t.getType() == Transaction.GROCERY).
 sorted(comparing(Transaction::getValue).reversed()).
 map(Transaction::getId).
 collect(toList());

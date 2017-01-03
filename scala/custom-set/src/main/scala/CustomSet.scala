/**
  *
  * @author Cedric Zhuang
  *
  */
object CustomSet {
  def fromList(list: List[Int]): Set[Int] = list.toSet

  def empty(set: Set[Int]): Boolean = set.isEmpty

  def member(set: Set[Int], value: Int): Boolean =
    set contains value

  def isSubsetOf(set1: Set[Int], set2: Set[Int]): Boolean =
    set1 subsetOf set2

  def isDisjointFrom(set1: Set[Int], set2: Set[Int]): Boolean =
    (set1 intersect set2).isEmpty

  def isEqual(set1: Set[Int], set2: Set[Int]): Boolean =
    set1 == set2

  def insert(set: Set[Int], value: Int): Set[Int] =
    set + value

  def intersection(set1: Set[Int], set2: Set[Int]): Set[Int] =
    set1 intersect set2

  def difference(set1: Set[Int], set2: Set[Int]): Set[Int] =
    set1 diff set2

  def union(set1: Set[Int], set2: Set[Int]): Set[Int] =
    set1 union set2
}

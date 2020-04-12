set -e
  javac Simple.java
function mytest { # class base
  echo 100s
  java $1 < ints-100-0.txt
  java $1 < ints-100-1.txt
  java $1 < ints-100-2.txt
  java $1 < ints-100-3.txt
  java $1 < ints-100-4.txt
  echo 200s
  java $1 < ints-200-1.txt
  java $1 < ints-200-2.txt
  java $1 < ints-200-3.txt
  java $1 < ints-200-4.txt
echo 400s
  java $1 < ints-400-0.txt
  java $1 < ints-400-1.txt
  java $1 < ints-400-2.txt
  java $1 < ints-400-3.txt
  java $1 < ints-400-4.txt
echo 800s
  java $1 < ints-800-0.txt
  java $1 < ints-800-1.txt
  java $1 < ints-800-2.txt
  java $1 < ints-800-3.txt
  java $1 < ints-800-4.txt
echo 1600s
  java $1 < ints-1600-0.txt

}
mytest Simple

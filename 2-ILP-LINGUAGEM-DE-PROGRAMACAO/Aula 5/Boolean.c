#include "Boolean.h"
#include <stdio.h>

int main() {
  printf("%s ", bool(not false));
  printf("%s ", bool(false and true));
  printf("%s ", bool(true or false));
  return 0;
}
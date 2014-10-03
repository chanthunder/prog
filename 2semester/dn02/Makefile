CC	= gcc
CFLAGS	= -std=c99 -pedantic -Wall
LIBS	= -lm

$(ID)	: $(ID).c
	@echo "=== COMPILING: ==="
	$(CC) $(CFLAGS) -o $@ $< $(LIBS)

test	: $(ID)
	@echo "=== TESTING: ==="
	ulimit -t 1 ; ./$(ID) < input-1 > result-1
	if diff result-1 output-1 ; then echo "1 - correct" ; fi
	ulimit -t 1 ; ./$(ID) < input-2 > result-2
	if diff result-2 output-2 ; then echo "2 - correct" ; fi
	ulimit -t 1 ; ./$(ID) < input-3 > result-3
	if diff result-3 output-3 ; then echo "3 - correct" ; fi
	ulimit -t 1 ; ./$(ID) < input-4 > result-4
	if diff result-4 output-4 ; then echo "4 - correct" ; fi
	ulimit -t 1 ; ./$(ID) < input-5 > result-5
	if diff result-5 output-5 ; then echo "5 - correct" ; fi
	ulimit -t 1 ; ./$(ID) < input-6 > result-6
	if diff result-6 output-6 ; then echo "6 - correct" ; fi
	ulimit -t 1 ; ./$(ID) < input-7 > result-7
	if diff result-7 output-7 ; then echo "7 - correct" ; fi
	ulimit -t 1 ; ./$(ID) < input-8 > result-8
	if diff result-8 output-8 ; then echo "8 - correct" ; fi
	ulimit -t 1 ; ./$(ID) < input-9 > result-9
	if diff result-9 output-9 ; then echo "9 - correct" ; fi

clean	:
	'rm' -fr $(ID) *~

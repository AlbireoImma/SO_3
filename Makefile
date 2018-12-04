tienda:
	javac *.java
run_tienda:
	java Tienda
clean:
	rm *.class -f
clean_logs:
	rm logs/*.txt -f
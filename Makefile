all:	
	rubber -d -f index.tex;
	bibtex index.aux;
	rubber -d -f index.tex;
	clear;
	rubber -d -f index.tex;
	rubber --clean index.tex;

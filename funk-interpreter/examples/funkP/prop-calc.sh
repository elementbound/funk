#!/bin/bash

source ascii-prez.sh

SNIPPET_DIR="snippets"
SRC_DIR="../src"

read 

page_start "Fordítóprogramok"

	text "Lokális változók és a Funk"

page_end

### ### ### ### 

page_start "Feladat"

	bullet "Lokális változók csak blokkokon belüli láthatósága" 

page_end 

### ### ### ### 

function code_page {
	page_start "Megvalósítás"
	
	bullet "Változók táblája"

	bullet "Tárolás Veremben"

	bullet "Ha új blokk jön..."

	bullet "Metódusok melyekkel kezeljük a tábláinkat"
	
	page_end
}

code_page
code "$SNIPPET_DIR/SymbolTable.java"

code_page
code "$SNIPPET_DIR/Stack.java"

code_page
code "$SNIPPET_DIR/Block.java"

code_page
code "$SNIPPET_DIR/Methods.java"



### ### ### ### 

page_start

text "Próbáljuk ki példa inputokra!"

page_end
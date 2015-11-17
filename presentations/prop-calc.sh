#!/bin/bash

source ascii-prez.sh

SNIPPET_DIR="snippets/prop-calc"
SRC_DIR="../propositional-calculus/src"
read 

page_start "Fordítóprogramok"

	text "A nulladrendű logika egy csúszós lejtő"
	text ""
	text "( igen, tényleg ilyen lesz az egész előadás )" 

page_end

### ### ### ### 

page_start "A feladat(ok)"

	bullet "A negációk csak atomokra vonatkozzanak"
	bullet "Csak diszjunkciók ( és szükségszerűen negációk )"
	bullet "Bónusz kör: Dupla tagadásokat ne nagyon"

page_end

### ### ### ### 

page_start "A kihívás(ok)"

	bullet "Szerkesszünk fát" 
	bullet "Ne mert nincs rá nagyon API"
	bullet "Kit érdekel"

page_end

### ### ### ### 

page_start "Parse, parse, parse"

	bullet "Sor értelmezése" 
	bullet "Fa kiírása módosítva"
	bullet "A sor legyen mostantól a kiírt"
	bullet "Előlről" 

page_end 

code "$SNIPPET_DIR/base-process.java"

### ### ### ### 

function code_page {
	page_start "Megvalósítás"

		bullet "Utility függvények"
		bullet "System.out vs. String"
		subblet "Egymás után fűzhető módosítások" 1
		bullet "Kiírás módosítva"
		subblet "Bónusz kör: Netán visitorok?" 1	

	page_end
}

code_page
code "$SNIPPET_DIR/utils.java"

code_page
code "$SNIPPET_DIR/negate.java"

code_page
code "$SNIPPET_DIR/sequential.java"

code_page
code "$SNIPPET_DIR/prune-negations.java"

### ### ### ### 

page_start "That's all, folks!"

text "Akkor én most kirakom a kódot és lehet kérdezni"
text ""
text "Akit érdekel, majd mutogathatom a prezentáció forrásait is" 

page_end

code "$SRC_DIR/Main.java"

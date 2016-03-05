#!/bin/bash

# Simple formatting #
function format_bold {
	tput bold;
}

function format_reset {
	tput sgr0
}

# Output # 

function page_start {
	clear;
	format_bold;
	printf "%s\n\n" "$1"
	format_reset; 
}

function text {
	echo $1;
}

function bullet {
	format_bold
	echo -n "  • "
	format_reset

	echo $1
	echo ""
}

function subblet {
	for i in $(seq $2)
	do 
		printf "  "
	done

	bullet "$1"
}

function page_end {
	read
}

function code {
	joe $1
}

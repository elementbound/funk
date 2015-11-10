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
	printf "%s\n\n" $1
	format_reset; 
}

function text {
	echo $1;
}

function page_end {
	read
}


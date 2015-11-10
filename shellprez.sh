#!/bin/bash

function page_start {
	clear;
}

function text {
	echo $1;
}

function page_end {
	read
}

page_start
text "Wow hai"
page_end

page_start
text "Thanks for ur attenshun dikhed"
page_end

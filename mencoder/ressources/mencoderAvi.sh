#!/bin/bash

#mencoderAvi.sh

input=$1
sub=$2
output=$3

mencoder $input\
	 -sub $sub\
	 -fontconfig\
	 -font Arial\
	 -subfont-text-scale 4\
	 -sub-bg-alpha 100\
	 -channels 6\
	 -ovc xvid\
	 -xvidencopts fixed_quant=4\
	 -vf harddup\
	 -oac pcm\
	 -o $output

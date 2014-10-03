#!/bin/bash
$ID = 63130301
for i in $ID-[0-9][0-9].c; do
    if [[ -f $i ]] then
        make $ID

    fi
done

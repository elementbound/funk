line = atomizeNegations(line);
line = toDisjunction(line);
line = pruneNegations(line);
//BAM! 

// ( Nem valójában nem csináljuk meg mindet, mert az első kettő üti egymást )

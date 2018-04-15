# 2dcanvas

__Requirement ambiguities__
1. The create canvas command according to the sample run either does not allow drawing on the left and right sides of
the canvas, or the examples are incorrect and have mistakenly not included an extra 2 characters in the width of the
canvas for drawing.

__Assumptions__
1. The create canvas command should create an area that reserves 2 characters in the x-dimension to be for the left and
right vertical border lines. This is not consistent with the y-dimension.

__Unsupported features__
1. Cannot draw diagonal lines.
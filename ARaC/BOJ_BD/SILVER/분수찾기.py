#왼쪽 대각선으로 내려갈때
left_down = (1,-1)
#오른쪽 대각선으로 올라갈때
rigth_up = (-1,1)
toggle = "right"

x = int(input())
position = []
position.append((1,1))
idx = 0

col =0
row =0
while idx+1 < x :
    col, row = position.pop()
    idx += 1
    #처음이거나 row축에 붙어 있을 경우 한칸 옮긴다.
    if col == 1 and toggle=="right" :
        row += 1
        position.append((col,row))
        toggle = "left"
        continue

    #col 축에 붙어 있을 경우 한칸 옮긴다
    if row == 1 and toggle =="left" :
        col += 1
        position.append((col,row))
        toggle = "right"
        continue

    if toggle == "left" :
        col += left_down[0]
        row += left_down[1]

    if toggle == "right" :
        col += rigth_up[0]
        row += rigth_up[1]

    position.append((col,row))

col, row = position.pop()
print(str(col) + "/" + str(row))

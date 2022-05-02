x = []
y = []
#Original
for i = 1:50
  x(i) = i - 1
  y(i) = sqrt(i - 1)
endfor


#Create array of 50 random numbers between 0 and 5
a = 5*rand(1, 50)

#Salt Data
newY = []
for i = 1:50
  newY(i) = y(i)+a(i)
endfor


#Smooth Data
smoothY = []
range = 3
sum = 0

for i = 1:46

  sum += (newY(i)+newY(i+1)+newY(i+2)+newY(i+3)+newY(i+4))
  smoothY(i) = (sum / range)
  sum = 0

endfor

newX = x([3:48])


plot(x, y, ";Original;")
hold on
plot(x, newY, ";Salted;")
hold on
plot(newX, smoothY, ";Smooth;")
title("Square Root Function")
xlabel("x values")
ylabel("y values")

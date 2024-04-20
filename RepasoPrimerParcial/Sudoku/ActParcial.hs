perm :: [Int] -> [[Int]]
perm [] = [[]]
perm xs = [ (y:ys) | y <- xs, ys <- perm (remove y xs)]

remove :: Int -> [Int] -> [Int]
remove y [] = []
remove y [x] = if(x == y) then [] else [x]
remove y (x:xs) 
    | x == y = xs 
    | otherwise = x : remove y xs

sudoku :: [Int] -> [[Int]]
sudoku [] = []
sudoku xs = res (perm [1..9]) xs

res :: [[Int]] -> [Int] -> [[Int]]
res [] [] = [[]]
res xs zs = [ ys | ys <- xs, elemInamovibles ys zs]

elemInamovibles :: [Int] -> [Int] -> Bool
elemInamovibles [] [] = True
elemInamovibles (x:xs) (y:ys)
    | y == 0 = elemInamovibles xs ys
    | otherwise = (x == y) && elemInamovibles xs ys

f :: Int -> Int
f 0 = 0
f k 
    | mod k 2 == 0 = 1 + min (f (div k 2)) (f(k-1))
    | otherwise = 1 + f (k-1)
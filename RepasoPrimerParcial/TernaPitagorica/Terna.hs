terna :: Int -> [(Int, Int, Int)]
terna 0 = [(0,0,0)]
terna n = [ (x, y, x*x + y*y) | x <- [0..n], y <- [0..n], x*x + y*y <= n ]


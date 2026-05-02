package main

import "fmt"

func main() {
	fmt.Println("Hello, World!")

	// for _, row := range doubleArr(5) {
	// 	fmt.Println(row)
	// }

	// fmt.Println("--------------------------------")

	// for _, row := range doubleArr2(5) {
	// 	fmt.Println(row)
	// }

	// fmt.Println("--------------------------------")

	// for _, row := range doubleArr3(5) {
	// 	fmt.Println(row)
	// }

	// fmt.Println(searchSS(doubleArr2(5), 34))
	// fmt.Println(DACsearchSS(doubleArr2(5), 23))
	searchSS(doubleArr2(5), 23)
	DACsearchSS(doubleArr2(5), 23)
}

// 5	10	15	20	25
// 6	11	16	21	26
// 7	12	17	22	27
// 8	13	18	23	28
// 9	14	19	24	29
func doubleArr(num int) [][]int {
	count := num
	tmp := make([][]int, num)

	for i := range tmp {
		tmp[i] = make([]int, num)
	}

	count = num
	for i := 0; i < num; i++ {
		for j := 0; j < num; j++ {
			tmp[i][j] = count
			count++
		}
	}

	return tmp
}

// 5	7	  8	  14	15
// 6	9	  13	16	23
// 10	12	17	22	24
// 11	18	21	25	28
// 19	20	26	27	29
func doubleArr2(num int) [][]int {
	M := make([][]int, num)
	for i := range M {
		M[i] = make([]int, num)
	}
	val := num
	for d := 0; d < 2*num-1; d++ {
		rMin := 0
		if d >= num {
			rMin = d - (num - 1)
		}
		rMax := d
		if rMax >= num {
			rMax = num - 1
		}
		if d%2 == 0 {
			for r := rMin; r <= rMax; r++ {
				M[r][d-r] = val
				val++
			}
		} else {
			for r := rMax; r >= rMin; r-- {
				M[r][d-r] = val
				val++
			}
		}
	}
	return M

}

// 5	10	15	20	25
// 6	11	16	21	26
// 7	12	17	22	27
// 8	13	18	23	28
// 9	14	19	24	29
func doubleArr3(num int) [][]int {
	count := num
	tmp := make([][]int, num)

	for i := range tmp {
		tmp[i] = make([]int, num)
	}

	count = num
	for i := 0; i < num; i++ {
		for j := 0; j < num; j++ {
			tmp[j][i] = count
			count++
		}
	}

	return tmp
}

// Time complexity: O(n^2)
// Because we are iterating through the entire matrix.
// Space complexity: O(1)
// Because we are not using any extra space.
func searchSS(M [][]int, key int) {
	n := len(M)
	r, c := 0, n-1

	for r < n && c >= 0 {
		if M[r][c] == key {
			fmt.Printf("(%d, %d)\n", r, c)
			return
		} else if M[r][c] > key {
			c--
		} else {
			r++
		}
	}
	fmt.Println("Not Found")
}

func dacSearch(M [][]int, key, r1, c1, r2, c2 int) (int, int, bool) {
	if r1 > r2 || c1 > c2 {
		return -1, -1, false
	}

	mr := (r1 + r2) / 2
	mc := (c1 + c2) / 2
	pivot := M[mr][mc]

	if key == pivot {
		return mr, mc, true
	}

	if key < pivot {
		if r, c, ok := dacSearch(M, key, r1, c1, mr-1, c2); ok {
			return r, c, true
		}
		if r, c, ok := dacSearch(M, key, mr, c1, r2, mc-1); ok {
			return r, c, true
		}
	} else {
		if r, c, ok := dacSearch(M, key, r1, mc+1, mr, c2); ok {
			return r, c, true
		}
		if r, c, ok := dacSearch(M, key, mr+1, c1, r2, c2); ok {
			return r, c, true
		}
	}
	return -1, -1, false
}

func DACsearchSS(M [][]int, key int) {
	n := len(M)
	r, c, found := dacSearch(M, key, 0, 0, n-1, n-1)
	if found {
		fmt.Printf("(%d, %d)\n", r, c)
	} else {
		fmt.Println("Not Found")
	}
}

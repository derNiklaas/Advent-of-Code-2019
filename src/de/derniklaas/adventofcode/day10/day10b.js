let amin = "#.#.##..#.###...##.#....##....###\n" +
    "...#..#.#.##.....#..##.#...###..#\n" +
    "####...#..#.##...#.##..####..#.#.\n" +
    "..#.#..#...#..####.##....#..####.\n" +
    "....##...#.##...#.#.#...#.#..##..\n" +
    ".#....#.##.#.##......#..#..#..#..\n" +
    ".#.......#.....#.....#...###.....\n" +
    "#.#.#.##..#.#...###.#.###....#..#\n" +
    "#.#..........##..###.......#...##\n" +
    "#.#.........##...##.#.##..####..#\n" +
    "###.#..#####...#..#.#...#..#.#...\n" +
    ".##.#.##.........####.#.#...##...\n" +
    "..##...#..###.....#.#...#.#..#.##\n" +
    ".#...#.....#....##...##...###...#\n" +
    "###...#..#....#............#.....\n" +
    ".#####.#......#.......#.#.##..#.#\n" +
    "#.#......#.#.#.#.......##..##..##\n" +
    ".#.##...##..#..##...##...##.....#\n" +
    "#.#...#.#.#.#.#..#...#...##...#.#\n" +
    "##.#..#....#..##.#.#....#.##...##\n" +
    "...###.#.#.......#.#..#..#...#.##\n" +
    ".....##......#.....#..###.....##.\n" +
    "........##..#.#........##.......#\n" +
    "#.##.##...##..###.#....#....###.#\n" +
    "..##.##....##.#..#.##..#.....#...\n" +
    ".#.#....##..###.#...##.#.#.#..#..\n" +
    "..#..##.##.#.##....#...#.........\n" +
    "#...#.#.#....#.......#.#...#..#.#\n" +
    "...###.##.#...#..#...##...##....#\n" +
    "...#..#.#.#..#####...#.#...####.#\n" +
    "##.#...#..##..#..###.#..........#\n" +
    "..........#..##..#..###...#..#...\n" +
    ".#.##...#....##.....#.#...##...##";
let asteroidmap = amin.split("\n").map(l => l.split(""));

function gcd_two_numbers(x, y) {
    if (typeof x !== "number" || typeof y !== "number") return false;
    x = Math.abs(x);
    y = Math.abs(y);
    while (y) {
        const t = y;
        y = x % y;
        x = t;
    }
    return x;
}

function getAngle(x1, y1, x2, y2) {
    let angleRadians = (Math.atan2(y1 - y2, x1 - x2) * 180) / Math.PI;
    angleRadians -= 90; // Make the rotation right
    if (angleRadians < 0) angleRadians += 360;
    console.log(x1, x2, y1, y2, angleRadians);
    return angleRadians;
}

function checkLineOfSight(startX, startY, stopX, stopY) {
    if (asteroidmap[stopY][stopX] !== "#") return false;
    if (asteroidmap[startY][startX] !== "#") return false;
    if (stopY === startY && stopX === startX) return false;
    let dy = stopY - startY;
    let dx = stopX - startX;
    if (dx === dy && dy === 0) {
    } else {
        let gcd = gcd_two_numbers(dy, dx);
        dy /= gcd;
        dx /= gcd;
    }
    let x = startX + dx;
    let y = startY + dy;
    let count = 0;
    while (asteroidmap[y] && asteroidmap[y][x]) {
        if (asteroidmap[y][x] === "#") {
            if (y === stopY && x === stopX) {
                return count;
            }
            count++;
            return false;
        }
        y += dy;
        x += dx;
    }
}

let maxCount = 0;
const y = 28;
const x = 22;

let count = 0;
let slopes = []; // [angle, numbers, x of asteroid, y of asteroid]
for (let y2 = 0; y2 < asteroidmap.length; y2++) {
    for (let x2 = 0; x2 < asteroidmap[0].length; x2++) {
        const los = checkLineOfSight(x, y, x2, y2);
        if (los === false) continue;
        slopes.push([getAngle(x, y, x2, y2), los, x2, y2]);
    }
}
slopes.sort((a, b) => (a[0] - b[0] === 0 ? a[1] - b[1] : a[0] - b[0]));
console.log(slopes[199][2] * 100 + slopes[199][3]);
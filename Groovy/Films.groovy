rentalIncrement = (rentalRate / replacementCost) * 0.45

if (rentalIncrement < 0) {
	rentalIncrement *= -1
} else if (rentalIncrement == 0) {
	rentalIncrement = 1
}

println 'Rental Increment = ' + rentalIncrement

return rentalIncrement
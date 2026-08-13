function* calc(initialValue) {
    let result = initialValue;

    while (true) {
        const input = yield result;

        if (!input || !["add", "subtract", "multiply", "divide"].includes(input.operation)) {
            yield "Invalid input";
            continue;
        }

        const value = Number(input.value);

        if (input.value === "" || isNaN(value)) {
            yield "Invalid input";
            continue;
        }

        switch (input.operation) {
            case "add":
                result += value;
                break;

            case "subtract":
                result -= value;
                break;

            case "multiply":
                result *= value;
                break;

            case "divide":
                if (value === 0) {
                    yield "Cannot divide by zero";
                    continue;
                }
                result /= value;
                break;
        }

        yield result;
    }
}

const calculator = calc(50);

console.log(calculator.next().value); 

console.log(calculator.next({ operation: "add", value: 30 }).value);

console.log(calculator.next({ operation: "multiply", value: "2" }).value);

console.log(calculator.next({ operation: "add", value: "30" }).value);

console.log(calculator.next({ operation: "multiply", value: 0 }).value);
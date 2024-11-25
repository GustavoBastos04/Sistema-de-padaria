import { useEffect, useState } from "react";
import {Table, Button} from "react-bootstrap";
import ItemEstoque from "../components/ListItems/ItemEstoque.jsx";
import DateSearchInput from "../components/SearchInputs/DateSearchInput.jsx"
import { api } from "../services/api.js";

function Estoque() {

    const [stock, setStock] = useState([])

    const [startDate, setStartDate] = useState("")
    const [endDate, setEndDate] = useState("")

    const [searchItem, setSearchItem] = useState("")
    const [currentPage, setCurrentPage] = useState(1)
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = stock.filter((item) => {
        const item_date = new Date(item.data_validade)
        const isDateInRange =
            (!startDate || item_date >= new Date(startDate)) &&
            (!endDate || item_date <= new Date(endDate))
        const matchesSearch = item?.nome?.toString().toLowerCase().includes(searchItem) ||
                              item?.quantidade?.toString().toLowerCase().includes(searchItem)
        return isDateInRange && matchesSearch
    })
    
    const currentItems = filteredItems.slice(indexOfFirstItem, indexOfLastItem)
    const totalPages = Math.ceil(filteredItems.length/itensPerPage)

    const handlePageChange = (pageNumber) => {
        setCurrentPage(pageNumber)
    }

    const handleDateSearch = (start, end) => {
        setStartDate(start)
        setEndDate(end)
        setCurrentPage(1)
    }

    async function loadStock() {
        const response = await api.get('estoque-atual-ingrediente')
        if (Array.isArray(response.data)) {
            const parsedSales = response.data.map((item) => ({
                ...item,
                data_validade: new Date(item.data_validade),
            }));
            setStock(parsedSales)
        }
    }    

    useEffect(() => {
        loadStock()
    }, [])

    return (
        <div>
            <DateSearchInput onSearch={handleDateSearch}/>
            <Table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Quantidade</th>
                        <th>Data de validade</th>
                    </tr>
                </thead>
                <tbody>
                {
                    currentItems.map((item) => {
                            return(
                                <ItemEstoque
                                key={item.id} 
                                nome={item.nome}
                                quantidade={item.quantidade}
                                data_validade={item.data_validade}
                                flag={1}
                                />
                            )
                        })
                    }
                </tbody>
            </Table>
            <div className="pagination d-flex justify-content-center align-itens-center">
                    {Array.from({length: totalPages}, (_, index) => (
                        <Button
                        key={index+1}
                        onClick={() => handlePageChange(index+1)}
                        variant={currentPage === index + 1 ? "primary" : "outline-primary"}
                        className="m-1"
                        >
                            {index+1}
                        </Button>
                    ))}
            </div>
        </div>
    )
}

export default Estoque
import { useEffect, useState } from "react";
import {Table, Button} from "react-bootstrap";
import ItemVenda from "../../components/ListItems/ItemVenda.jsx";
import { api } from '../../services/api' 
import DateSearchInput from "../../components/SearchInputs/DateSearchInput.jsx";

function HistoricoVendas() {
 
    const [sales, setSales] = useState([])

    const [startDate, setStartDate] = useState("")
    const [endDate, setEndDate] = useState("")

    const [currentPage, setCurrentPage] = useState(1)
    const [searchItem, setSearchItem] = useState("")
    const itensPerPage = 10

    const indexOfLastItem = currentPage * itensPerPage
    const indexOfFirstItem = indexOfLastItem - itensPerPage
    
    const filteredItems = sales.filter((item) => {
        const item_date = new Date(item.data_de_venda)
        const isDateInRange =
            (!startDate || item_date >= new Date(startDate)) &&
            (!endDate || item_date <= new Date(endDate))
        const matchesSearch = item?.id_venda?.toString().toLowerCase().includes(searchItem) ||
                              item?.valor?.toString().toLowerCase().includes(searchItem)
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

    async function loadSales() {
        const response = await api.get('venda');
        if (Array.isArray(response.data)) {
            const parsedSales = response.data.map((item) => ({
                ...item,
                data_de_venda: new Date(item.data_de_venda),
            }));
            setSales(parsedSales)
        }
    }    

    useEffect(() => {
        loadSales()
    }, [])

    return (
        <div>
            <DateSearchInput onSearch={handleDateSearch}/>
            <Table>
                <thead>
                    <tr>
                        <th>ID da venda</th>
                        <th>Valor</th>
                        <th>Data</th>
                    </tr>
                </thead>
                <tbody>
                {
                    currentItems.map((item) => {
                            return(
                                <ItemVenda
                                key={item.id} 
                                id_venda={item.id_venda}
                                valor={item.valor}
                                data_de_venda={item.data_de_venda}
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

export default HistoricoVendas;
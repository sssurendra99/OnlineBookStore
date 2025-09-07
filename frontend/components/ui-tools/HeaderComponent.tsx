import { Link } from 'react-router-dom';
import { UserRound, Search, ShoppingBag } from 'lucide-react';


const HeaderComponent = () => {
  return (
    <div className='flex justify-between w-[1440px] items-center'>
        <div className='flex gap-15 items-center'>
            <div className='font-playfair'>
                <h1 className='font-bold text-4xl text-[#ae2f29]'>.Pusthaka</h1>
            </div>
            <div className='font-epunda text-xl items-center tracking-wider'>
                <ul className='flex gap-12 items-baseline'>
                    <Link to="/"><li>Home</li></Link>
                    <Link to="#"><li>Books</li></Link>
                    <Link to="#"><li>About Us</li></Link>
                    <Link to="#"><li>Contact</li></Link>
                </ul>
            </div>
        </div>
        <div>
            <ul className='flex gap-7'>
                <Link to=""><UserRound /></Link>
                <Link to=""><Search /></Link>
                <Link to=""><ShoppingBag /></Link>
            </ul>

        </div>
    </div>
  )
}

export default HeaderComponent;